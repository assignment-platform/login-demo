package assignment.platform.demo.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
    private List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
        users.add(new User("001", "000"));
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if(users.contains(user)) {
            return ResponseEntity.ok().body("登录成功");
        }

        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用户名或密码错误");
    }
}
