package com.nothing.advertisement_website;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AdController {

	@Autowired
	IAdService adService;
	
	
	@GetMapping("/ping")
	public String doPing() {
		return "ping";
	}

	@RequestMapping("/showAds")
	public String showAds(HttpServletRequest request) {

		List<Ad> out = adService.getAllAds().stream().map((Ad e) -> {

			Image img = Image.extract(e.getPhotoImg());
			System.err.println("ct:" + img.getContentType());
			System.err.println("img:" + img.getContent().substring(0, 5));
			String imgDataUrl = HTMLUtils.createDataUrl(img.getContentType(), img.getContent());
			System.err.println("imgDataUrl :" + imgDataUrl.substring(0, 20));

			e.setPhotoImg(imgDataUrl);

			return e;
		}).collect(Collectors.toList());

//		Function<Ad, List<Ad>> fn = (e) -> {
//			List<Ad> out;
//			return list;
//		};

		// System.err.println(list.get(0).getPhotoImg());
//		Image img = Image.extract(list.get(0).getPhotoImg());
//		// log.info("@@@ the photoImg {}", Image.extract(list.get(0).getPhotoImg()));
//
//		String imgDataUrl = HTMLUtils.createDataUrl(img.getContentType(), img.getContent());

		request.setAttribute("ads", out);

		return "monitor";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/showCheckoutScreen")
	public String goToCheckoutTerminal(Model model, HttpServletRequest req) {

		System.err.println("adId:" + req.getParameter("adId"));

		Ad tempAd = adService.getAdByAdId((UUID.fromString(req.getParameter("adId"))));

		Image img = Image.extract(tempAd.getPhotoImg());

		String imgDataUrl = HTMLUtils.createDataUrl(img.getContentType(), img.getContent());

		tempAd.setPhotoImg(imgDataUrl);
		System.err.println("tempAd name:" + tempAd.getName());
		System.err.println("tempAd amount:" + tempAd.getAmount());
		System.err.println("tempAd details:" + tempAd.getDetails());



		req.setAttribute("ad", tempAd);

		return "checkout";
	}

}
