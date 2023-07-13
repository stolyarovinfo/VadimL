package ru.Vadim.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Vadim.telegrambot.entities.Client;

@RepositoryRestResource(collectionResourceRel = "clients",path = "clients")
public interface ClientRepository extends JpaRepository<Client,Long> {
}