package com.cognizant.service.test ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import com.cognizant.model.User;
import com.cognizant.repository.UserRepository;
import com.cognizant.service.CustomUserDetailService;

@SpringBootTest
public class CustomUserDetailServiceTest {

	
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private CustomUserDetailService service;
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void loadUserByUserNameShouldUserNameTest() {
		when(userRepository.findByUserName("admin")).thenReturn(new User(1,"admin","admin"));
		assertThat(service.loadUserByUsername("admin")).isNotNull();
		verify(userRepository, Mockito.times(1)).findByUserName("admin");
	}
	
	

	
}
