package com.security.JWT.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    //Kiểm tra xem user có tồn tại trong database không?
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    //JwtAuthenticationFilter sẽ xử dụng hàm này
    @Transactional
    public UserDetails loadUserById(Long id){
        User user=userRepository.findById(id).orElseThrow(()->
                new UsernameNotFoundException("User not found with id : "+id));
        return new CustomUserDetails(user);
    }
}
