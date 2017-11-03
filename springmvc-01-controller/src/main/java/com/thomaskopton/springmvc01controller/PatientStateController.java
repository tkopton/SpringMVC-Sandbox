package com.thomaskopton.springmvc01controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.thomaskopton.springmvc01domain.PatientState;
import com.thomaskopton.springmvc01exceptions.NoPatientStateFoundUnderHealthStateException;
import com.thomaskopton.springmvc01exceptions.PatientStateNotFoundException;
import com.thomaskopton.springmvc01domain.service.PatientStateService;

@Controller
@RequestMapping("annotation")
public class PatientStateController {

	@Autowired
	private PatientStateService patientStateService;

	@RequestMapping("/patientstates")
	public String list(Model model) {
		model.addAttribute("patientstates", patientStateService.getAllPatientStates());

		return "patientstates";
	}

	@RequestMapping("/patientstates/{healthstate}")
	public String getPatientStatesByHealthState(Model model, @PathVariable("healthstate") String healthState) {
		model.addAttribute("patientstates", patientStateService.getPatientStatesByHealthState(healthState));

		return "patientstates";
	}

	@RequestMapping("/patientstates/filter/{params}")
	public String getPatientStatesByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams,
			Model model) {
		List<PatientState> patientstates = patientStateService.getPatientStatesByFilter(filterParams);
		if (patientstates == null || patientstates.isEmpty()) {
			throw new NoPatientStateFoundUnderHealthStateException();
		}
		model.addAttribute("patientstates", patientstates);

		return "patientstates";
	}

	@RequestMapping(value = "/patientstates/add", method = RequestMethod.GET)
	public String getAddNewPatientStateForm(Model model) {
		PatientState newPatientState = new PatientState();
		model.addAttribute("newPatientState", newPatientState);

		return "addPatientState";
	}

	@RequestMapping(value = "/patientstates/add", method = RequestMethod.POST)
	public String processAddNewPatientStateForm(@ModelAttribute("newPatientState") PatientState newPatientState,
			BindingResult result, HttpServletRequest request) {

		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		MultipartFile actionPlan01 = newPatientState.getActionPlan01();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		if (actionPlan01 != null && !actionPlan01.isEmpty()) {
			try {
				actionPlan01.transferTo(
						new File(rootDirectory + "resources\\images\\" + newPatientState.getEventId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}

		patientStateService.addPatientSate(newPatientState);
		return "redirect:/annotation/patientstates";
	}

	@RequestMapping("/patientstate")
	public String getPatientStateByEventId(@RequestParam("eventid") String eventId, Model model) {
		model.addAttribute("patientstate", patientStateService.getPatientStateByEventId(eventId));

		return "patientstate";
	}

	@RequestMapping("/update/casestate")
	public String updateCaseStates(Model model) {
		patientStateService.updateAllCaseStates();

		return "redirect:/annotation/patientstates";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("eventId", "caseState", "patientId", "healthState", "emotionalState", "patientPosition",
				"patientLocation", "audioSequenze", "videoSequenze", "actionPlan01");
	}
	
	@ExceptionHandler(PatientStateNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, PatientStateNotFoundException exception) {
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("invalidHealthState", exception.getHealthState());
	    mav.addObject("exception", exception);
	    mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
	    mav.setViewName("healthStateNotFound");
	    return mav;
	}
	
	@RequestMapping("/patientstates/invalidCode")
	public String invalidCode() {
	      return "invalidCode";
	}
}
