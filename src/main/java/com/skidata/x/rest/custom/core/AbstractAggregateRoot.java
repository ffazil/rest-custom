package com.skidata.x.rest.custom.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.util.List;

/**
 * @author firoz
 * @since 23/04/17
 */
@Getter
@ToString
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public class AbstractAggregateRoot extends org.springframework.data.domain.AbstractAggregateRoot
        implements Identifiable<Long> {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final  Long id;

    @Version
    private Long version;

    protected AbstractAggregateRoot() {
        this.id = null;
    }

    @Override
    @JsonIgnore
    public List<Object> getDomainEvents() {
        return super.getDomainEvents();
    }
}