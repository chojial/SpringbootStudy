package springboot.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
/**
 * @ControllerAdvice是一个@Component，用于定义@ExceptionHandler，@InitBinder
 * 和@ModelAttribute方法，适用于所有使用@RequestMapping方法。
 * 只有配合@ExceptionHandler最有用，其它两个不常
 * @author Administrator
 *
 */
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request , Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("errorPage");
		return mav;
		
	}

}
