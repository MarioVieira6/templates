/*
 *  COPYRIGHT FINCH Solucoes (www.finchsolucoes.com.br)
 *  TODOS OS DIREITOS RESERVADOS
 *  PROPRIEDADE CONFIDENCIAL NAO PUBLICADA DA FINCH
 *  
 *  criado em Sep 20, 2017
 * 
 */

package br.com.report;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test applicationContext.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public abstract class BasicTest {

}
