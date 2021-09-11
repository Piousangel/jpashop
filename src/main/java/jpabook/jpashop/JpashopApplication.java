package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication              //SpringBootApplication 어노테이션이 있으면 이 패키지, 패키지 하위까지 스프링이 컴포넌트 스캔을 한다 -> 스프링 빈으로 자동 등록해줌.
public class JpashopApplication {

	public static void main(String[] args) {

		//lombok -> 알아서 getter, setter 만들어준다
//		Hello hello = new Hello();
//		hello.setData("hello");
//		String data = hello.getData();
//
//		System.out.println("data = " + data);

		SpringApplication.run(JpashopApplication.class, args);
	}

}
