package assignment.platform.demo.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public ResponseEntity<String> login(@RequestBody User user, HttpSession session) {
        if (users.contains(user)) {
            session.setAttribute("user", user);
            return ResponseEntity.ok().body("登录成功");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用户名或密码错误");
    }

    @GetMapping("/user/about")
    public ResponseEntity<String> about(HttpSession session) {
        Object object = session.getAttribute("user");
        if (object == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("您没有权限执行此操作");
        }

        if (object instanceof User) {
            User user = (User) object;
            return ResponseEntity.ok("my id is " + user.getId());
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("您没有权限执行此操作");
    }


}
