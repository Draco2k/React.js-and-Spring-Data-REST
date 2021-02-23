package app.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DataBaseLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.save(new Employee("amir", "kimiyae", "a Fucking idiot"));
        employeeRepository.save(new Employee("hades", "the big dick", "the great"));
    }

}
