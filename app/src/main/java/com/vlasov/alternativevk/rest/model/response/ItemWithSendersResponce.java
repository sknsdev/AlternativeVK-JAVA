package com.vlasov.alternativevk.rest.model.response;

import com.vlasov.alternativevk.model.Group;
import com.vlasov.alternativevk.model.Owner;
import com.vlasov.alternativevk.model.Profile;

import java.util.ArrayList;
import java.util.List;

public class ItemWithSendersResponce<T> extends BaseItemResponse<T> {
    private List<Profile> profiles = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

    private List<Profile> getProfiles() {
        return profiles;
    }

    private List<Group> getGroups() {
        return groups;
    }

    private List<Owner> getAllSenders() {
        List<Owner> all = new ArrayList<>();
        all.addAll(getProfiles());
        all.addAll(getGroups());
        return all;
    }

    public Owner getSender(int id) {
        for (Owner owner : getAllSenders()) {
            if (owner.getId() == Math.abs(id)) {
                return owner;
            }
        }
        return null;
    }
}
