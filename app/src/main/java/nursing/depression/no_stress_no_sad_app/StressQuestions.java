package nursing.depression.no_stress_no_sad_app;

public class StressQuestions {
   public String stressQuestion[] = {
           "กลัวทำงานผิดพลาด",
           "ไปไม่ถึงเป้าหมายที่วางไว้ ",
           "ครอบครัวมีความขัดแย้งกันในเรื่องเงินหรือเรื่องงานในบ้าน",
           "เป็นกังวลกับเรื่องสารพิษหรือมลภาวะในอากาศ น้ำ เสียง และดิน",
           "รู้สึกว่าต้องแข่งขันหรือเปรียบเทียบ",
           "เงินไม่พอใช้จ่าย",
           "กล้ามเนื้อตึงหรือปวด",
           "ปวดหัวจากความตึงเครียด",
           "ปวดหลัง",
           "ความอยากอาหารเปลี่ยนแปลง",
           "ปวดศีรษะข้างเดียว",
           "รู้สึกวิตกกังวล",
           "รู้สึกคับข้องใจ",
           "รู้สึกโกรธ หรือหงุดหงิด",
           "รู้สึกเศร้า",
           "ความจำไม่ดี",
           "รู้สึกสับสน",
           "ตั้งสมาธิลำบาก",
           "รู้สึกเหนื่อยง่าย",
           "เป็นหวัดบ่อย"
   };
   public String getStressQuestion(int a) {
       String question = stressQuestion[a];
       return question;
   }
}
