package com.spring.restful.rest;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restful.business.ReportService;

/**
 * <code>Controller</code> basico.
 */
@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "*")
public class REST {

    /**
     * Logs.
     */
    public static Log logger = LogFactory.getLog(REST.class);

    /**
     * Injetando dependecia no <i>servico</i> de exemplo.
     */
    @Autowired
    private ReportService reportService;

    /**
     * @return mensagem de boas vindas
     */
    @RequestMapping("/")
    public String home() {

        logger.info("[REST]-Validando Componente endpoint.");

        return "API RESTful validada! " + new Date().toString();
    }

    /**
     * Imprime relatorio na tela..
     *
     * @return Mensagem para o usuario final
     */
    @RequestMapping("/report")
    public String printReport() {
        return reportService.printReport();
    }
}
