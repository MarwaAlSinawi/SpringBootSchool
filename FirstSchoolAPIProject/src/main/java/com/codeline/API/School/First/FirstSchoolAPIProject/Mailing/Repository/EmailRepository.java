package com.codeline.API.School.First.FirstSchoolAPIProject.Mailing.Repository;

import com.codeline.API.School.First.FirstSchoolAPIProject.Mailing.Models.EmailDetails;

public interface EmailRepository {
    String sendSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);


}
