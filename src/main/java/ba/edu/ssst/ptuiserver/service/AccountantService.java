package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.Accountant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountantService {
    ArrayList<Accountant> accountants = new ArrayList<>();

    public AccountantService() {
        accountants.add(new Accountant(0L, "Nedim"));
        accountants.add(new Accountant(1L, "Harun"));
        accountants.add(new Accountant(2L, "Berina"));
        accountants.add(new Accountant(3L, "Mujo"));
    }

    public List<Accountant> get() {
        return accountants;
    }

    public Accountant get(Long id) {
        if (id == null) {
            return null;
        }
        return accountants.stream().filter(acc -> acc.getId().equals(id)).findAny().orElse(null);
    }

    public Accountant save(Accountant accountant) {
        accountants.add(accountant);
        return accountant;
    }

    public Accountant update(Long id, Accountant accountant) {
        if (id == null) {
            return null;
        }
        Accountant existing = accountants.stream().filter(acc -> acc.getId().equals(id)).findAny().orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setName(accountant.getName());
        existing.setId(accountant.getId());
        return existing;
    }

    public void delete(Long id) {
        if (id != null) {
            accountants.removeIf(acc -> acc.getId().equals(id));
        }
    }

}
