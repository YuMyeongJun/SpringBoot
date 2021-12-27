package edu.dl.project01.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter @Getter
public class Server extends Item{
    String manufacturer;
    String serialNumber;
    String etc;
}
