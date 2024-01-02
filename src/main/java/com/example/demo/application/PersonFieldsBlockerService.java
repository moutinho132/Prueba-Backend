package com.example.demo.application;

import com.example.demo.domain.models.Customer;
import com.example.demo.domain.models.Person;
import com.example.demo.domain.models.User;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PersonFieldsBlockerService {

    private SecurityManagementService securityService;

    public List<?> block(final List<?> items,final String token) {
        if (!CollectionUtils.isEmpty(items)) {
            final User user = securityService.findCurrentUser(token);
            return items.stream()
                    .map(item -> block(user, item))
                    .collect(Collectors.toList());
        }
        return items;
    }

    public Object block(final Object item,final String token) {
        final User user = securityService.findCurrentUser(token);
        return block(user, item);
    }

    public Object block(final User user, final Object item) {
        if (item instanceof Customer && Objects.nonNull(((Customer) item).getPerson())) {
            return ((Customer) item).withPerson(block(((Customer) item).getPerson(), user, item.getClass()));
        }
        return item;
    }

    private Person block(final Person person, final User user, final Class<?> clazz) {
        return person
                .withName(person.getName())
                .withSurname(person.getSurname());
    }


}
