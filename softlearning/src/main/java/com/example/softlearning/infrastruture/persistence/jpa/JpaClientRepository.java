package com.example.softlearning.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.softlearning.applicationcore.entity.client.dtos.ClientDTO;
import com.example.softlearning.applicationcore.entity.client.persistence.ClientRepository;

import jakarta.transaction.Transactional;

@Repository
public interface JpaClientRepository extends JpaRepository<ClientDTO, Integer>, ClientRepository {
    
    public Optional<ClientDTO> findById(int id);

    @Query(value="SELECT c FROM ClientDTO c WHERE c.name LIKE %:name%")
    public List<ClientDTO> findByName(String name);
 
    @Transactional
    public ClientDTO save(ClientDTO client);
    
    public void deleteById(int id);  
}