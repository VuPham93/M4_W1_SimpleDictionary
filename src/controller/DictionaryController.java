package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public ModelAndView dictionary(@RequestParam String input){
        String result = translate(input);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("result", result);

        return modelAndView;
    }

    private static String translate(String input) {
        HashMap<String, String > words = new HashMap<>();
        words.put("hello", "Xin chào");
        words.put("monday", "Thứ Hai");
        words.put("money", "Tiền");
        words.put("mouse", "Con chuột");

        if (words.containsKey(input)) {
            return words.get(input);
        }
        return "Can't translate";
    }


}
