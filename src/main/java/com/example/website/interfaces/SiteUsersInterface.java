package com.example.website.interfaces;

import com.example.website.models.SiteUsers;
import org.springframework.data.repository.CrudRepository;

public interface SiteUsersInterface extends CrudRepository<SiteUsers, Long> {
}
