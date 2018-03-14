package com.example.android.assignment09app;

import java.util.ArrayList;

/**
 * Created by Android on 11/1/2017.
 */

public class MemberSet {
    private static MemberSet memberSet;
    private ArrayList<Member> members = new ArrayList<Member>();

    private MemberSet() {
        members.add(new Member("Jin", "Kim Seokjin","December 4, 1992",24,R.drawable.bts_jin, R.raw.jawake, "Awake", "Ah…Jin. He's the oldest member of the group and, sadly, one of the group’s worst dancers. He’s not at all bothered by it though because he’s definitely one of the members with the best looks (he was scouted on the street due to his looks alone). Check out his solo song, Awake, below – written by fellow members Rap Monster and J-Hope!"));
        members.add(new Member("Suga", "Min Yoongi","March 9, 1993",24,R.drawable.bts_suga, R.raw.sugafirstlove, "First Love", "Suga is definitely BTS's grumpiest member. Despite loving music, fellow members, and his fans, he would probably rather sleep all day if he wasn’t in the music industry. Named for having pale skin that rivals the color of sugar, his songs tell the opposite. Check out his solo song below where he sings about his First Love…the piano!"));
        members.add(new Member("J-Hope", "Jung Hoseok","February 18, 1994",23,R.drawable.bts_j_hope, R.raw.jhmama, "Mama", "J-hope is a dancer and rapper of BTS. Before joining BTS, he was part of an underground dance group. Because of this, he along with the other “better” dancers in the group are often helping fellow members Jin and Rap Monster improve (and surprisingly, you can tell it’s working). Check out his solo song, Mama, below!"));
        members.add(new Member("Rap Monster ", "Kim Namjoon (김남준)","September 12, 1994",23,R.drawable.bts_rap_monster, R.raw.rmreflection, "Reflection", "Rap Monster (despite having a slightly corny name) definitely lives up to his stage name by being one of Koreas best rappers. In fact, his entertainment company took one look at him and heard his rhymes and decided that they needed to make a group with him in it as the leader. He’s one of BTS’s main songwriters and not just for his rap portion, having written most of the group’s songs and is also credited for writing fellow members Jungkook and Jin’s solo songs from the Wings album and it’s repackaged version You Never Walk Alone. But don’t put him anywhere near your fine China. He’s definitely the clumsiest guy you’d ever meet. Check out his solo song, Reflection, below!"));
        members.add(new Member("Jimin", "Park Jimin","October 13, 1995",22,R.drawable.bts_jimin, R.raw.jmlie, "Lie", "Jimin is a lead vocalist and a main dancer of BTS. He became interested in performance after watching singer Rain (Korean singer and actor that starred in the Hollywood films Speed Racer and Ninja Assassin) perform in eighth grade. He subsequently moved to Busan High School of Arts modern dance department. He decided to audition with BigHit Entertainment after his dance teacher suggested he audition for an entertainment company. After being accepted, he transferred to Korea Arts High School is Seoul, graduating alongside group-mate V (Kim Taehyung) in 2013. Check out his solo song, Lie, below!"));
        members.add(new Member("V", "Kim Taehyung","December 30, 1995",21,R.drawable.bts_v, R.raw.vstigma, "Stigma", "V’s definitely the oddball member. Of the singers, he’s immediately recognized by his deep voice. Although he comes off as one of the most serious guy’s you’ll meet, he’s probably the goofiest, always ready to laugh or do something odd or strange. He has a strong love for rap songs (and probably wishes he was a rapper himself) and is always ready to rap Rap Monster, Suga, and J-Hope’s Cypher tracks. Check out his solo song, Stigma, below!"));
        members.add(new Member("Jungkook", "Kim Jungkook","September 1, 1997",20,R.drawable.bts_jungkook, R.raw.jkbegin, "Begin", "As the youngest member, Jungkook certainly packs a lot of talent. He’s one of the group’s main vocals and best dancers. Because of this, he’s definitely hard to miss when the group is doing live performances! Check out his solo song, Begin, below – written by fellow member Rap Monster – where he sings about how the older members in the group were like true brothers to him."));
    }

    public static MemberSet getMemberSet() {
        if(memberSet == null){
            memberSet = new MemberSet();
        }
        return memberSet;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public Member getMember(int id) {
        if(id < 0 || id >= members.size()) return null;
        return members.get(id);
    }

}
