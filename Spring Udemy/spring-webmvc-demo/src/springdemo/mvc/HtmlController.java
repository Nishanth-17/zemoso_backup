package springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HtmlController {
	@RequestMapping("/showForm")
	public String showForm() {
		return "htmlform";
	}
	@RequestMapping("/processForm")
	public String processForm() {
		return "html-resp";
	}
	@RequestMapping("/processForm2")
	public String displayName(HttpServletRequest request,Model model) {
		String name=request.getParameter("studentName");
		name=name.toUpperCase();
		String msg="Hey , "+name;
		model.addAttribute("message",msg);
		return "html-resp";
	}
	@RequestMapping("/processForm3")
	public String displayNameReqparam(@RequestParam("studentName") String theName,Model model) {
		theName=theName.toUpperCase();
		String msg="Hey , "+theName +". We used RequestParam annotation for reading your name";
		model.addAttribute("message",msg);
		return "html-resp";
	}

}
