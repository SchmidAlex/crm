package ch.zli.m223.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.crm.model.Customer;
import ch.zli.m223.crm.model.impl.CustomerImpl;
import ch.zli.m223.crm.model.impl.MemoImpl;

public interface MemoRepository extends JpaRepository<MemoImpl, Long>{

	public default Customer setMemos(Customer editCustomer, List<String> memos) {
		CustomerImpl customer = (CustomerImpl)editCustomer;
		for (String memo : memos) {
			MemoImpl dbMemo = save(new MemoImpl(memo, customer));
			customer.addMemo(dbMemo);
		}
		return editCustomer;
	}
}
