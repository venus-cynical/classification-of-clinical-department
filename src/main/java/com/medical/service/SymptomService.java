package com.medical.service;

import com.medical.model.Symptom;
import com.medical.model.SymptomCategory;
import com.medical.model.BodyPart;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SymptomService {
    private Map<String, Symptom> symptoms = new HashMap<>();

    @PostConstruct
    public void init() {
        // 消化器系の症状
        addSymptom("1", "腹痛", "持続的または強い腹痛がある場合", "消化器内科", 
            SymptomCategory.DIGESTIVE, Set.of(BodyPart.STOMACH, BodyPart.INTESTINE), "中度", "中");
        
        addSymptom("2", "消化不良", "食後の膨満感、腹部の不快感、吐き気、嘔吐など", "消化器内科", 
            SymptomCategory.DIGESTIVE, Set.of(BodyPart.STOMACH), "中度", "低");
        
        addSymptom("3", "下痢・便秘", "急に下痢が続く、または便秘が長期間続く場合", "消化器内科", 
            SymptomCategory.DIGESTIVE, Set.of(BodyPart.INTESTINE), "中度", "低");
        
        addSymptom("4", "血便・黒色便", "便に血が混じっている、またはタール状の便が出る場合", "消化器内科", 
            SymptomCategory.DIGESTIVE, Set.of(BodyPart.INTESTINE), "重度", "高");
        
        addSymptom("5", "体重減少", "理由がわからないのに体重が減少する場合", "消化器内科/内科", 
            SymptomCategory.DIGESTIVE, Set.of(BodyPart.WHOLE_BODY), "中度", "中");
        
        addSymptom("6", "飲食時の痛み", "飲み込むときに痛みを感じる、嚥下障害がある場合", "消化器内科/耳鼻咽喉科", 
            SymptomCategory.DIGESTIVE, Set.of(BodyPart.THROAT), "中度", "中");
        
        addSymptom("7", "食欲不振", "持続的な食欲の減退がある場合", "消化器内科/内科", 
            SymptomCategory.DIGESTIVE, Set.of(BodyPart.STOMACH), "中度", "中");
        
        addSymptom("8", "胸焼け・逆流", "胸やけが頻繁に起こる、または食物が逆流する感覚がある場合", "消化器内科", 
            SymptomCategory.DIGESTIVE, Set.of(BodyPart.STOMACH, BodyPart.THROAT), "中度", "低");
        
        addSymptom("9", "黄疸", "皮膚や目の白い部分が黄ばんでいる場合", "消化器内科", 
            SymptomCategory.DIGESTIVE, Set.of(BodyPart.LIVER, BodyPart.SKIN), "重度", "高");
        
        addSymptom("10", "腹部の腫れ・しこり", "腹部に異常な腫れやしこりを感じる場合", "消化器内科", 
            SymptomCategory.DIGESTIVE, Set.of(BodyPart.STOMACH, BodyPart.INTESTINE), "重度", "高");

        // その他の一般的な症状
        addSymptom("11", "発熱", "38度以上の熱がある", "内科", 
            SymptomCategory.GENERAL, Set.of(BodyPart.WHOLE_BODY), "中度", "中");
        
        addSymptom("12", "頭痛", "継続的な頭痛がある", "脳神経外科/内科", 
            SymptomCategory.HEAD, Set.of(BodyPart.HEAD), "中度", "中");
        
        addSymptom("13", "関節の痛み", "関節に痛みや腫れがある", "整形外科", 
            SymptomCategory.LIMBS, Set.of(BodyPart.JOINT), "中度", "低");
        
        addSymptom("14", "皮膚の発疹", "皮膚に発疹や痒みがある", "皮膚科", 
            SymptomCategory.SKIN, Set.of(BodyPart.SKIN), "軽度", "低");
        
        addSymptom("15", "目の痛み・かすみ", "目に違和感や視界がぼやける", "眼科", 
            SymptomCategory.HEAD, Set.of(BodyPart.EYE), "中度", "中");

        // 脳神経系の症状
        addSymptom("16", "重度の頭痛", "突然の激しい頭痛や、持続的で徐々に強くなる頭痛", "脳神経外科/脳神経内科", 
            SymptomCategory.HEAD, Set.of(BodyPart.HEAD), "重度", "高");
            
        addSymptom("17", "意識障害", "意識がぼんやりする、もうろうとする、または失神する", "脳神経外科/救急", 
            SymptomCategory.HEAD, Set.of(BodyPart.HEAD, BodyPart.WHOLE_BODY), "重度", "高");
            
        addSymptom("18", "運動障害", "手足の麻痺、脱力感、動かしにくさがある", "脳神経内科/脳神経外科", 
            SymptomCategory.HEAD, Set.of(BodyPart.ARM, BodyPart.LEG, BodyPart.WHOLE_BODY), "重度", "高");
            
        addSymptom("19", "感覚異常", "手足のしびれや感覚の鈍化が起こる", "脳神経内科", 
            SymptomCategory.HEAD, Set.of(BodyPart.ARM, BodyPart.LEG, BodyPart.WHOLE_BODY), "中度", "中");
            
        addSymptom("20", "言語障害", "言葉が出にくい、話しにくい、他人の言葉が理解できない", "脳神経内科/脳神経外科", 
            SymptomCategory.HEAD, Set.of(BodyPart.HEAD), "重度", "高");
            
        addSymptom("21", "けいれん発作", "突然の意識消失を伴うけいれんや、異常行動が起こる", "脳神経外科/脳神経内科", 
            SymptomCategory.HEAD, Set.of(BodyPart.WHOLE_BODY), "重度", "高");
            
        addSymptom("22", "記憶障害", "最近の出来事を忘れやすい、新しい記憶が定着しにくい", "脳神経内科", 
            SymptomCategory.HEAD, Set.of(BodyPart.HEAD), "中度", "中");
            
        addSymptom("23", "性格・行動の変化", "突然の性格変化や感情の不安定さが現れる", "脳神経内科/精神科", 
            SymptomCategory.MENTAL, Set.of(BodyPart.HEAD), "中度", "中");
            
        addSymptom("24", "原因不明の疲労感", "持続的な疲労感や倦怠感が続く", "脳神経内科/内科", 
            SymptomCategory.GENERAL, Set.of(BodyPart.WHOLE_BODY), "中度", "中");

        // 整形外科の症状
        addSymptom("25", "重度の関節痛", "膝、肩、肘、手首などの関節に強い痛みがある", "整形外科", 
            SymptomCategory.LIMBS, Set.of(BodyPart.JOINT), "重度", "中");
            
        addSymptom("26", "筋肉の痛みと痙攣", "筋肉の持続的な痛み、しびれ、または痙攣がある", "整形外科", 
            SymptomCategory.LIMBS, Set.of(BodyPart.ARM, BodyPart.LEG), "中度", "低");
            
        addSymptom("27", "骨折の疑い", "外傷や転倒により強い痛みがあり、骨折が疑われる", "整形外科/救急", 
            SymptomCategory.LIMBS, Set.of(BodyPart.ARM, BodyPart.LEG, BodyPart.JOINT), "重度", "高");
            
        addSymptom("28", "関節の腫れと変形", "関節や手足に腫れや明らかな変形がある", "整形外科", 
            SymptomCategory.LIMBS, Set.of(BodyPart.JOINT, BodyPart.ARM, BodyPart.LEG), "重度", "中");
            
        addSymptom("29", "関節可動域制限", "関節が正常に動かせない、または動かすと強い痛みがある", "整形外科", 
            SymptomCategory.LIMBS, Set.of(BodyPart.JOINT), "中度", "中");
            
        addSymptom("30", "腰痛", "持続的な腰の痛みやしびれ、坐骨神経痛を伴う", "整形外科", 
            SymptomCategory.LIMBS, Set.of(BodyPart.BACK), "中度", "中");
            
        addSymptom("31", "スポーツ外傷", "スポーツ活動中の捻挫や肉離れなどの怪我", "整形外科", 
            SymptomCategory.LIMBS, Set.of(BodyPart.JOINT, BodyPart.ARM, BodyPart.LEG), "中度", "中");
            
        addSymptom("32", "神経性の痛み", "手足の痛みが神経に沿って放散する（腱鞘炎など）", "整形外科", 
            SymptomCategory.LIMBS, Set.of(BodyPart.ARM, BodyPart.LEG, BodyPart.JOINT), "中度", "中");
            
        addSymptom("33", "疲労骨折", "過度の運動による骨の疲労が原因の痛み", "整形外科", 
            SymptomCategory.LIMBS, Set.of(BodyPart.LEG, BodyPart.JOINT), "中度", "中");
            
        addSymptom("34", "脱臼", "関節が外れる、または外れかけている感覚がある", "整形外科/救急", 
            SymptomCategory.LIMBS, Set.of(BodyPart.JOINT), "重度", "高");

        // 耳鼻咽喉科の症状
        // 耳の症状
        addSymptom("35", "耳の痛みと不快感", "耳の痛み、かゆみ、圧迫感がある", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.EAR), "中度", "中");
            
        addSymptom("36", "耳鳴り", "耳の中で音が鳴る、ブーンという音がする", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.EAR), "中度", "中");
            
        addSymptom("37", "聴力低下", "音が聞こえにくい、聞こえが悪くなった", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.EAR), "中度", "中");
            
        addSymptom("38", "耳からの分泌物", "耳から液体や膿が出る", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.EAR), "中度", "高");
            
        addSymptom("39", "めまい", "回転性のめまいや立ちくらみがある", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.EAR, BodyPart.HEAD), "中度", "中");
            
        addSymptom("40", "外耳炎", "外耳道の痛み、腫れ、かゆみがある", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.EAR), "中度", "中");

        // 鼻の症状
        addSymptom("41", "鼻づまり", "鼻が詰まって呼吸がしにくい", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.NOSE), "軽度", "低");
            
        addSymptom("42", "鼻水・鼻汁", "透明または色のついた鼻水が出る", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.NOSE), "軽度", "低");
            
        addSymptom("43", "アレルギー性鼻炎", "くしゃみ、鼻水、鼻のかゆみが続く", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.NOSE), "軽度", "低");
            
        addSymptom("44", "頻繁な鼻出血", "鼻血が頻繁に出る", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.NOSE), "中度", "中");
            
        addSymptom("45", "副鼻腔の痛み", "頬やおでこ周辺の痛み、蓄膿症の可能性", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.NOSE, BodyPart.FACE), "中度", "中");
            
        addSymptom("46", "嗅覚障害", "匂いがわからない、または異常に感じる", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.NOSE), "中度", "中");

        // 喉の症状
        addSymptom("47", "喉の痛み", "急性または慢性の喉の痛みがある", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.THROAT), "中度", "中");
            
        addSymptom("48", "嚥下障害", "食べ物や飲み物が飲み込みにくい", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.THROAT), "中度", "中");
            
        addSymptom("49", "声の異常", "声がかすれる、出にくい、変化する", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.THROAT), "中度", "中");
            
        addSymptom("50", "喉の違和感", "喉に何かが引っかかっているような感覚", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.THROAT), "軽度", "低");
            
        addSymptom("51", "慢性的な咳", "喉の不調による頻繁な咳", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.THROAT), "中度", "中");
            
        addSymptom("52", "扁桃腺の腫れ", "扁桃腺が腫れて痛みがある", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.THROAT), "中度", "高");

        // 耳鼻科関連の全身症状
        addSymptom("53", "耳鼻科関連の発熱", "耳、鼻、喉の感染症による発熱", "耳鼻咽喉科", 
            SymptomCategory.GENERAL, Set.of(BodyPart.WHOLE_BODY), "中度", "中");
            
        addSymptom("54", "耳鼻科関連の頭痛", "耳や副鼻腔の問題による頭痛", "耳鼻咽喉科", 
            SymptomCategory.HEAD, Set.of(BodyPart.HEAD), "中度", "中");
    }

    private void addSymptom(String id, String name, String description, String department,
                          SymptomCategory category, Set<BodyPart> bodyParts, String severity, String urgency) {
        Symptom symptom = new Symptom();
        symptom.setId(id);
        symptom.setName(name);
        symptom.setDescription(description);
        symptom.setRecommendedDepartment(department);
        symptom.setCategory(category);
        symptom.setRelatedBodyParts(bodyParts);
        symptom.setSeverity(severity);
        symptom.setUrgency(urgency);
        symptoms.put(id, symptom);
    }

    public List<Symptom> getAllSymptoms() {
        return new ArrayList<>(symptoms.values());
    }

    public Symptom getSymptomById(String id) {
        return symptoms.get(id);
    }

    public List<Symptom> getSymptomsByCategory(SymptomCategory category) {
        return symptoms.values().stream()
                .filter(s -> s.getCategory() == category)
                .collect(Collectors.toList());
    }

    public List<Symptom> getSymptomsByBodyPart(BodyPart bodyPart) {
        return symptoms.values().stream()
                .filter(s -> s.getRelatedBodyParts().contains(bodyPart))
                .collect(Collectors.toList());
    }

    public Set<SymptomCategory> getAllCategories() {
        return symptoms.values().stream()
                .map(Symptom::getCategory)
                .collect(Collectors.toSet());
    }

    public Set<BodyPart> getAllBodyParts() {
        return symptoms.values().stream()
                .flatMap(s -> s.getRelatedBodyParts().stream())
                .collect(Collectors.toSet());
    }
} 