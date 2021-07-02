package de.facemirrored.appschattenzorn.controller;

import de.facemirrored.appschattenzorn.rest.model.User;
import de.facemirrored.appschattenzorn.rest.user.LoadProfileResponse;
import de.facemirrored.appschattenzorn.security.services.UserDetailsImpl;
import de.facemirrored.appschattenzorn.security.services.userdetails.UserDetailsServiceImpl;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasRole('USER')")
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserDetailsServiceImpl userDetailsService;

  @GetMapping("/getUser")
  public ResponseEntity<LoadProfileResponse> getUser(Authentication authentication) {
    UserDetailsImpl userDetails =
        (UserDetailsImpl) userDetailsService.loadUserByUsername(authentication.getName());
    return ResponseEntity.ok(LoadProfileResponse.builder().user(User.builder()
        .email(userDetails.getEmail()).username(userDetails.getUsername())
        .roles(userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(
            Collectors.toList()))
        .build()).build());
  }
}
