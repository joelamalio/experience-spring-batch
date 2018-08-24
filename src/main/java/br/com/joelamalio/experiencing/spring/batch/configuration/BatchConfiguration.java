package br.com.joelamalio.experiencing.spring.batch.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import br.com.joelamalio.experiencing.spring.batch.domain.Person;
import br.com.joelamalio.experiencing.spring.batch.listener.JobCompletionNotificationListener;
import br.com.joelamalio.experiencing.spring.batch.processor.PersonItemProcessor;
import br.com.joelamalio.experiencing.spring.batch.vo.PersonVo;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public FlatFileItemReader<PersonVo> reader() {
		FlatFileItemReaderBuilder<PersonVo> builder = new FlatFileItemReaderBuilder<PersonVo>().name("personItemReader")
				.resource(new ClassPathResource("person/person_3.csv")).delimited()
				.names(new String[] { "name", "birthday", "sex" })
				.fieldSetMapper(new BeanWrapperFieldSetMapper<PersonVo>() {
					{
						setTargetType(PersonVo.class);
					}
				});
		return builder.build();
	}

	@Bean
	public PersonItemProcessor processor() {
		return new PersonItemProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Person>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO people (name, birthday, sex) VALUES (:name, :birthday, :sex.id)")
				.dataSource(dataSource).build();
	}

	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step1)
				.end().build();
	}

	@Bean
	public Step step1(JdbcBatchItemWriter<Person> writer) {
		return stepBuilderFactory.get("step1").<PersonVo, Person>chunk(10).reader(reader()).processor(processor())
				.writer(writer).build();
	}

}
