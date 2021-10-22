package ch.zli.m223.crm.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.crm.model.impl.AppUserImpl;
import ch.zli.m223.crm.model.impl.CustomerImpl;
import ch.zli.m223.crm.repository.CustomerRepository;
import ch.zli.m223.crm.repository.MemoRepository;
import ch.zli.m223.crm.repository.RoleRepository;
import ch.zli.m223.crm.repository.UserRepository;

@Component
public class ServerInitializer implements ApplicationRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MemoRepository memoRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> chefe = new ArrayList<>();
		chefe.add("El Chefe");
		chefe.add("El Arschloche");
		AppUserImpl user = userRepository.save(new AppUserImpl("Alexmail", "AlexPasswort"));
		roleRepository.setRoles(user, chefe);
		chefe.clear();
		
		chefe.add("Lehrling");
		chefe.add("Prakti");
		
		AppUserImpl prakti = userRepository.save(new AppUserImpl("Second", "SeconPW"));
		roleRepository.setRoles(prakti, chefe);
		userRepository.save(new AppUserImpl("Third", "ThirdPW"));
		
		
		
		
		CustomerImpl customer = customerRepository.save(new CustomerImpl("Name", "Street", "City"));
		memoRepository.setMemos(customer, "blablabla");
		
	}

}
