package com.codeline.API.School.First.FirstSchoolAPIProject.Mailing.Models;

import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailDetails {
    private List<String> recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
