package com.pblgllgs.sb3mcsvccompany.company.clients;
/*
 *
 * @author pblgl
 * Created on 13-11-2024
 *
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("review")
public interface ReviewClient {

    @GetMapping("/reviews/averageRating")
    Double getAverageRating(@RequestParam("companyId") Long companyId);
}
