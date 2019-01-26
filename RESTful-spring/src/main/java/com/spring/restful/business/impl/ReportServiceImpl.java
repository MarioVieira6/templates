/**
 *
 */
package com.spring.restful.business.impl;

import org.springframework.stereotype.Service;

import com.spring.restful.business.ReportService;

/**
 * Exemplifica a implementacao do <i>servico</i>.
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public String printReport() {
        return "The reportService is implemented!";
    }
}
