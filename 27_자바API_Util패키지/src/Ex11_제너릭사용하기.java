import kr.hossam.sample.Sample1;
import kr.hossam.sample.Sample2;
import kr.hossam.sample.Sample3;
import kr.hossam.sample.UseGen;

public class Ex11_제너릭사용하기 {
    public static void main(String[] args) {
        UseGen<Sample1> u1 = new UseGen<Sample1>();
        u1.setSample(new Sample1());

        Sample1 s1 =u1.getSample();
        s1.say();

        UseGen<Sample2> u2 = new UseGen<Sample2>();
        u2.setSample(new Sample2());

        Sample2 s2 = u2.getSample();
        s2.say();

        UseGen<Sample3> u3 = new UseGen<Sample3>();
        u3.setSample(new Sample3());

        Sample3 s3 = u3.getSample();
        s3.say();
    }
}
