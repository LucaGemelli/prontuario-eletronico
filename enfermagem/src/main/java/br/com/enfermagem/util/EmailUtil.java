package br.com.enfermagem.util;

import br.com.enfermagem.dto.LoginDTO;
import br.com.enfermagem.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.UUID;

@Component
@Slf4j
public class EmailUtil {

    private final JavaMailSender javaMailSender;

    public EmailUtil(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(LoginDTO dto) {
        try {
            MimeMessage msg = this.javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);

            String novaSenha = randomPassword();

            helper.setFrom("projetosades@gmail.com");
            helper.setTo(dto.getEmail());
            helper.setSubject("Nova senha de acesso");
            helper.setText(String.format("Nova senha para acesso ao sistema: %s", novaSenha));

            this.javaMailSender.send(msg);
            dto.setSenha(novaSenha);
        } catch (MailException | MessagingException e) {
            log.error("Erro no envio do e-mail: {} ", e.getMessage());
            throw new BusinessException("Erro ao enviar e-mail");
        }
    }

    private static String randomPassword() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(UUID.randomUUID().toString().replace("-", ""))
                .substring(0, 10);
    }
}
