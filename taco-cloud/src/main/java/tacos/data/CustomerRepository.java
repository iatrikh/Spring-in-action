package tacos.data;

import org.springframework.data.repository.CrudRepository;

import tacos.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByUsername(String username);
}
