package edu.apcs.testReview.frq2021;

import java.util.ArrayList;

public class ClubMembers {
    private ArrayList<MemberInfo> memberList;

    public void addMember(String[] names, int gradYear) {
        for(int i = 0; i < names.length; i++){
            memberList.add(new MemberInfo(names[i], gradYear, true));
        }
    }

    public ArrayList<MemberInfo> removeMembers(int year) {
        ArrayList<MemberInfo> removed = new ArrayList<MemberInfo>();

        for(int i = 0; i < memberList.size(); i++){
            if(memberList.get(i).getGradYear() == year && memberList.get(i).inGoodStanding()){
                removed.add(memberList.get(i));
                memberList.remove(i);
            }
        }
        return removed;
    }
}
