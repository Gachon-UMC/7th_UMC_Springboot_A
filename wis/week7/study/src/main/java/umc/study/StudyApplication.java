package umc.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.study.service.StoreService.StoreQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class StudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeService = context.getBean(StoreQueryService.class);

			// 파라미터 값 설정
			String name = "요아정";
			String address = "대치동";

			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findStoresByNameAndAddress with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Address: " + address);

			storeService.findStoresByNameAndAddress(name, address)
					.forEach(System.out::println);
		};
	}
}
