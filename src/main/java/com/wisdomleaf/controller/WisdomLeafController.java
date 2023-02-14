package com.wisdomleaf.controller;
import com.wisdomleaf.service.WisdomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
//This is the contorller of the class which accepts the text and send the response in form of words
public class WisdomLeafController
{
    @Autowired
    private WisdomService wisdomService;

    private static final Logger logger = LoggerFactory.getLogger(WisdomLeafController.class);

        @PostMapping("/speaking-clock")
        public String hello(@RequestBody String time)
        {
            if (logger.isInfoEnabled()) {
                logger.info("controller method is called ...");
            }
            String output=wisdomService.convertNumberToWords(time);
        return output;
        }
}
