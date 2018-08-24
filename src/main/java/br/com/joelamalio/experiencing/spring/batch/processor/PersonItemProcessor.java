package br.com.joelamalio.experiencing.spring.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import br.com.joelamalio.experiencing.spring.batch.domain.Person;
import br.com.joelamalio.experiencing.spring.batch.domain.Sex;
import br.com.joelamalio.experiencing.spring.batch.util.DateUtil;
import br.com.joelamalio.experiencing.spring.batch.vo.PersonVo;

public class PersonItemProcessor implements ItemProcessor<PersonVo, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

	@Override
	public Person process(PersonVo vo) throws Exception {
		Person person = new Person();
    	person.setName(vo.getName());
    	person.setBirthday(DateUtil.formatDateDDMMYYYY(vo.getBirthday()));
    	person.setSex(Sex.get(vo.getSex()));
    	
        log.info("Converting from (" + vo + ") to (" + person + ")");

        return person;
	}
    

}
