package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.dao.PhotoDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.awt.color.ProfileDataException;
import java.security.Principal;
import java.util.List;



@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class AccountController {



}