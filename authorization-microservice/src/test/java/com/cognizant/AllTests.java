package com.cognizant;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cognizant.controller.test.AuthControllerTests;
import com.cognizant.model.test.AuthorizationModelTest;
import com.cognizant.service.test.CustomUserDetailServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ AuthControllerTests.class,AuthorizationModelTest.class, CustomUserDetailServiceTest.class })
public class AllTests {}
