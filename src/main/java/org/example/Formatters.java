package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.deque.html.axecore.results.Rule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Formatters {

    private final ObjectMapper objectMapper;

    public Formatters() {
        this.objectMapper = new ObjectMapper();
    }

    public void formatJson(String inputFile, String outputFile) {
        try {
            objectMapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);

            Object json = objectMapper.readValue(new File(inputFile), Object.class);
            objectMapper.writeValue(new File(outputFile), json);
        } catch (IOException e) {
            System.err.println("Error formatting JSON: " + e.getMessage());
        }
    }

    public void convertJsonToHtmlReport(String jsonFile, String htmlFile) {
        try {
            List<Rule> violations = objectMapper.readValue(new File(jsonFile), new TypeReference<List<Rule>>() {});
            StringBuilder htmlContent = new StringBuilder();
            htmlContent.append("<!DOCTYPE html>\n<html>\n<head>\n<title>Accessibility Report</title>\n")
                    .append("<style>\n")
                    .append("body { font-family: Arial, sans-serif; margin: 20px; padding: 20px; }\n")
                    .append("h1 { color: #333; }\n")
                    .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }\n")
                    .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }\n")
                    .append("th { background-color: #f2f2f2; }\n")
                    .append(".critical { color: red; font-weight: bold; }\n")
                    .append(".serious { color: orange; font-weight: bold; }\n")
                    .append(".moderate { color: blue; font-weight: bold; }\n")
                    .append(".minor { color: green; font-weight: bold; }\n")
                    .append("</style>\n</head>\n<body>\n")
                    .append("<h1>Accessibility Violations Report</h1>\n");

            if (violations.isEmpty()) {
                htmlContent.append("<p>No accessibility violations found. ✅</p>");
            } else {
                htmlContent.append("<table>\n<tr>\n<th>Rule</th>\n<th>Description</th>\n<th>Impact</th>\n<th>Help URL</th>\n<th>Affected Elements</th>\n<th>Failure Summary</th>\n</tr>\n");

                for (Rule violation : violations) {
                    String impactClass = (violation.getImpact() != null) ? violation.getImpact().toLowerCase() : "unknown";

                    for (var node : violation.getNodes()) {
                        htmlContent.append("<tr>\n")
                                .append("<td>").append(violation.getId()).append("</td>\n") // Rule ID
                                .append("<td>").append(violation.getDescription()).append("</td>\n") // Description
                                .append("<td class=\"").append(impactClass).append("\">")
                                .append(violation.getImpact() != null ? violation.getImpact() : "N/A")
                                .append("</td>\n")
                                .append("<td><a href=\"").append(violation.getHelpUrl()).append("\" target=\"_blank\">Help Link</a></td>\n") // Help URL
                                .append("<td><code>").append(node.getHtml()).append("</code></td>\n") // Affected Element
                                .append("<td>").append(node.getFailureSummary() != null ? node.getFailureSummary().replace("\n", "<br>") : "N/A").append("</td>\n") // Failure Summary
                                .append("</tr>\n");
                    }
                }
                htmlContent.append("</table>\n");
            }

            htmlContent.append("</body>\n</html>");
            Files.write(Paths.get(htmlFile), htmlContent.toString().getBytes());

        } catch (IOException e) {
            System.err.println("Error generating HTML report: " + e.getMessage());
        }
    }

}
