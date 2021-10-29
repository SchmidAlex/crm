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
import ch.zli.m223.crm.role.Roles;

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
		List<String> roles = new ArrayList<>();
		
		roles.clear();
		roles.add(Roles.USER);
		AppUserImpl user = userRepository.save(new AppUserImpl("user", "user"));
		roleRepository.setRoles(user, roles);
		
		roles.clear();
		roles.add(Roles.ADMIN);
		user = userRepository.save(new AppUserImpl("admin", "admin"));
		roleRepository.setRoles(user, roles);
		
		roles.clear();
		roles.add(Roles.ADMIN);
		roles.add(Roles.USER);
		user = userRepository.save(new AppUserImpl("usmin", "usmin"));
		roleRepository.setRoles(user, roles);
		
		CustomerImpl customer = customerRepository.save(new CustomerImpl("Name", "Street", "City"));
		memoRepository.setMemos(customer, "blablabla");
		
	}

}
