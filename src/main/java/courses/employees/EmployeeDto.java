package courses.employees;

import courses.employees.internal.Employee;
import org.jetbrains.annotations.Debug;

import java.io.Serializable;

/**
 * DTO for {@link Employee}
 */
@Debug.Renderer(text = """
        String.format("(%d) %s", id, name)
        """)
public record EmployeeDto(Long id, String name) implements Serializable {
}