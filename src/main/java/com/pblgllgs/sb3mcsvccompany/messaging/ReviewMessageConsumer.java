package com.pblgllgs.sb3mcsvccompany.messaging;
/*
 *
 * @author pblgl
 * Created on 13-11-2024
 *
 */

import com.pblgllgs.sb3mcsvccompany.company.CompanyService;
import com.pblgllgs.sb3mcsvccompany.dto.ReviewMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageConsumer {

    private final CompanyService companyService;

    public ReviewMessageConsumer(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RabbitListener(queues = "companyRatingQueue")
    public void consumeMessage(ReviewMessage reviewMessage) {
        companyService.updateCompanyRating(reviewMessage);
    }
}
