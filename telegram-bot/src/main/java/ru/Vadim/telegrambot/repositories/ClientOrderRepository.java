package ru.Vadim.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Vadim.telegrambot.entities.ClientOrder;

@RepositoryRestResource(collectionResourceRel = "clientOrders",path = "clientOrders")
public interface ClientOrderRepository extends JpaRepository<ClientOrder,Long> {
}