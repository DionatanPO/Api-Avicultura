/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api_avicultura.exporter;

import com.example.api_avicultura.model.Lote;
import com.example.api_avicultura.model.Ovo;
import com.example.api_avicultura.model.Pesagem;
import com.example.api_avicultura.model.Vacina;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Dionatan
 */
public class ExcelFileExporter {

    public static ByteArrayInputStream contactListToExcelFile(
            List<Lote> lotes, List<List<Pesagem>> pesagens, List<List<Ovo>> ovos, List<List<Vacina>> vacinas) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Produtor");

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            Cell cell = row.createCell(0);
            cell.setCellValue("Nome");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Propriedade");
            cell.setCellStyle(headerCellStyle);
            
            cell = row.createCell(2);
            cell.setCellValue("Qtd. Lotes");
            cell.setCellStyle(headerCellStyle);

            Row dataRow1 = sheet.createRow(1);
            dataRow1.createCell(0).setCellValue(lotes.get(0).getProdutor().getNome());
            dataRow1.createCell(1).setCellValue(lotes.get(0).getProdutor().getNome_propriedade());
            dataRow1.createCell(2).setCellValue(lotes.size());

       
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

//-------------------------------------Lote--------------------------------------------------------
            Sheet sheet2 = workbook.createSheet("Lote");

            Row row2 = sheet2.createRow(0);

            Cell cell2 = row2.createCell(0);
            cell2.setCellValue("Identificação");
            cell2.setCellStyle(headerCellStyle);

            cell2 = row2.createCell(1);
            cell2.setCellValue("Data Abertura");
            cell2.setCellStyle(headerCellStyle);

            cell2 = row2.createCell(2);
            cell2.setCellValue("Data Fechamento");
            cell2.setCellStyle(headerCellStyle);

            cell2 = row2.createCell(3);
            cell2.setCellValue("Peso Inicial");
            cell2.setCellStyle(headerCellStyle);

            cell2 = row2.createCell(4);
            cell2.setCellValue("Peso Médio");
            cell2.setCellStyle(headerCellStyle);

            cell2 = row2.createCell(5);
            cell2.setCellValue("Peso Final");
            cell2.setCellStyle(headerCellStyle);

            cell2 = row2.createCell(6);
            cell2.setCellValue("Qtd. Aves Ini.");
            cell2.setCellStyle(headerCellStyle);

            cell2 = row2.createCell(7);
            cell2.setCellValue("Qtd. Aves Mortas");
            cell2.setCellStyle(headerCellStyle);

            cell2 = row2.createCell(8);
            cell2.setCellValue("Qtd. Aves Fin.");
            cell2.setCellStyle(headerCellStyle);

            cell2 = row2.createCell(9);
            cell2.setCellValue("Qtd. Ração Ini.");
            cell2.setCellStyle(headerCellStyle);

            cell2 = row2.createCell(10);
            cell2.setCellValue("Qtd. Ração Consum.");
            cell2.setCellStyle(headerCellStyle);

            cell2 = row2.createCell(11);
            cell2.setCellValue("Qtd. Ração Fin.");
            cell2.setCellStyle(headerCellStyle);

            cell2 = row2.createCell(12);
            cell2.setCellValue("Tipo");
            cell2.setCellStyle(headerCellStyle);

            for (int i = 0; i < lotes.size(); i++) {

                Row dataRow = sheet2.createRow(i + 1);
                dataRow.createCell(0).setCellValue(lotes.get(i).getIdentificacao());

                try {
                    String data = new SimpleDateFormat("dd/MM/yyyy").format(lotes.get(i).getData_abertura());
                    dataRow.createCell(1).setCellValue(data);

                } catch (Exception e) {
                    dataRow.createCell(1).setCellValue("");

                }
                try {
                    String data = new SimpleDateFormat("dd/MM/yyyy").format(lotes.get(i).getData_abate());

                    dataRow.createCell(2).setCellValue(data);
                } catch (Exception e) {

                    dataRow.createCell(2).setCellValue("");
                }

                dataRow.createCell(3).setCellValue(lotes.get(i).getPeso_inicial());
                dataRow.createCell(4).setCellValue(lotes.get(i).getPeso_medio());
                dataRow.createCell(5).setCellValue(lotes.get(i).getPeso_final());
                dataRow.createCell(6).setCellValue(lotes.get(i).getQ_aves_inicial());
                dataRow.createCell(7).setCellValue(lotes.get(i).getQ_aves_mortas());
                dataRow.createCell(8).setCellValue(lotes.get(i).getQ_aves_final());
                dataRow.createCell(9).setCellValue(lotes.get(i).getRacao_inicial());
                dataRow.createCell(10).setCellValue(lotes.get(i).getRacao_inicial() - lotes.get(i).getRacao_final());
                dataRow.createCell(11).setCellValue(lotes.get(i).getRacao_final());
                dataRow.createCell(12).setCellValue(lotes.get(i).getTipo());

            }

            sheet2.autoSizeColumn(0);
            sheet2.autoSizeColumn(1);
            sheet2.autoSizeColumn(2);
            sheet2.autoSizeColumn(3);
            sheet2.autoSizeColumn(4);
            sheet2.autoSizeColumn(5);
            sheet2.autoSizeColumn(6);
            sheet2.autoSizeColumn(7);
            sheet2.autoSizeColumn(8);
            sheet2.autoSizeColumn(9);
            sheet2.autoSizeColumn(10);
            sheet2.autoSizeColumn(11);
            sheet2.autoSizeColumn(12);

//--------------------------Pesagens------------------------------------------------------------------------------
            Sheet sheet3 = workbook.createSheet("Pesagens");

            Row row3 = sheet3.createRow(0);

            Cell cell3 = row3.createCell(0);
            cell3.setCellValue("Lote");
            cell3.setCellStyle(headerCellStyle);

            cell3 = row3.createCell(1);
            cell3.setCellValue("Data");
            cell3.setCellStyle(headerCellStyle);

            cell3 = row3.createCell(2);
            cell3.setCellValue("Tipo");
            cell3.setCellStyle(headerCellStyle);

            cell3 = row3.createCell(3);
            cell3.setCellValue("Nº Aves pesadas");
            cell3.setCellStyle(headerCellStyle);

            cell3 = row3.createCell(4);
            cell3.setCellValue("Peso médio");
            cell3.setCellStyle(headerCellStyle);

            cell3 = row3.createCell(5);
            cell3.setCellValue("Nº Aves dentro média");
            cell3.setCellStyle(headerCellStyle);

            cell3 = row3.createCell(6);
            cell3.setCellValue("Nº Aves fora média");
            cell3.setCellStyle(headerCellStyle);

            int aux = 1;
            for (int i = 0; i < pesagens.size(); i++) {


                for (int c = 0; c < pesagens.get(i).size(); c++) {


                    Row dataRow = sheet3.createRow(aux);

                    dataRow.createCell(0).setCellValue(pesagens.get(i).get(c).getLote().getIdentificacao());
                    try {
                        String data = new SimpleDateFormat("dd/MM/yyyy").format(pesagens.get(i).get(c).getData_pesagem());
                        dataRow.createCell(1).setCellValue(data);

                    } catch (Exception e) {
                        dataRow.createCell(1).setCellValue("");

                    }

                    dataRow.createCell(2).setCellValue(pesagens.get(i).get(c).getTipo());
                    dataRow.createCell(3).setCellValue(pesagens.get(i).get(c).getN_aves_pesadas());
                    dataRow.createCell(4).setCellValue(pesagens.get(i).get(c).getPeso_medio());
                    dataRow.createCell(5).setCellValue(pesagens.get(i).get(c).getN_aves_dentro_media());
                    dataRow.createCell(6).setCellValue(pesagens.get(i).get(c).getN_aves_fora_media());

                    aux++;
                }
            }

            sheet3.autoSizeColumn(0);
            sheet3.autoSizeColumn(1);
            sheet3.autoSizeColumn(2);
            sheet3.autoSizeColumn(3);
            sheet3.autoSizeColumn(4);
            sheet3.autoSizeColumn(5);
            sheet3.autoSizeColumn(6);

//---------------------Coletas de Ovos---------------------------------------------------------------------------
            Sheet sheet4 = workbook.createSheet("Coleta de Ovos");

            Row row4 = sheet4.createRow(0);
            Cell cell4 = row4.createCell(0);
            cell4.setCellValue("Lote");
            cell4.setCellStyle(headerCellStyle);

            cell4 = row4.createCell(1);
            cell4.setCellValue("Qtd. Ovos coletados");
            cell4.setCellStyle(headerCellStyle);

            cell4 = row4.createCell(2);
            cell4.setCellValue("Data");
            cell4.setCellStyle(headerCellStyle);
            
            aux = 1;
            for (int i = 0; i < ovos.size(); i++) {

                for (int c = 0; c < ovos.get(i).size(); c++) {

                    Row dataRow = sheet4.createRow(aux);

                    dataRow.createCell(0).setCellValue(ovos.get(i).get(c).getLote().getIdentificacao());
                    dataRow.createCell(1).setCellValue(ovos.get(i).get(c).getQuantidade());

                    try {
                        String data = new SimpleDateFormat("dd/MM/yyyy").format(ovos.get(i).get(c).getData_coleta());
                        dataRow.createCell(2).setCellValue(data);

                    } catch (Exception e) {
                        dataRow.createCell(2).setCellValue("");

                    }

                    aux++;
                }
            }

            sheet4.autoSizeColumn(0);
            sheet4.autoSizeColumn(1);
            sheet4.autoSizeColumn(2);

//------------------------Vacinação---------------------------------------------------------------------------------
            Sheet sheet5 = workbook.createSheet("Vacinação");

            Row row5 = sheet5.createRow(0);

            Cell cell5 = row5.createCell(0);
            cell5.setCellValue("Lote");
            cell5.setCellStyle(headerCellStyle);

            cell5 = row5.createCell(1);
            cell5.setCellValue("Data");
            cell5.setCellStyle(headerCellStyle);

            cell5 = row5.createCell(2);
            cell5.setCellValue("Nome");
            cell5.setCellStyle(headerCellStyle);

            cell5 = row5.createCell(3);
            cell5.setCellValue("Idade em dia");
            cell5.setCellStyle(headerCellStyle);

            cell5 = row5.createCell(4);
            cell5.setCellValue("Idade em semana");
            cell5.setCellStyle(headerCellStyle);

            cell5 = row5.createCell(5);
            cell5.setCellValue("Via de administração");
            cell5.setCellStyle(headerCellStyle);
            
            cell5 = row5.createCell(6);
            cell5.setCellValue("Nº Aves vacinadas");
            cell5.setCellStyle(headerCellStyle);

            aux = 1;
            for (int i = 0; i < vacinas.size(); i++) {


                for (int c = 0; c < vacinas.get(i).size(); c++) {


                    Row dataRow = sheet5.createRow(aux);

                    dataRow.createCell(0).setCellValue(vacinas.get(i).get(c).getLote().getIdentificacao());

                    try {
                        String data = new SimpleDateFormat("dd/MM/yyyy").format(vacinas.get(i).get(c).getData_vacinacao());
                        dataRow.createCell(1).setCellValue(data);

                    } catch (Exception e) {
                        dataRow.createCell(1).setCellValue("");

                    }

                    dataRow.createCell(2).setCellValue(vacinas.get(i).get(c).getNome_vacina());
                    dataRow.createCell(3).setCellValue(vacinas.get(i).get(c).getIdade_dia());
                    dataRow.createCell(4).setCellValue(vacinas.get(i).get(c).getIdade_semana());
                    dataRow.createCell(5).setCellValue(vacinas.get(i).get(c).getVia_administracao());
                    dataRow.createCell(6).setCellValue(vacinas.get(i).get(c).getN_aves_vacinadas());

                    aux++;
                }
            }

            sheet5.autoSizeColumn(0);
            sheet5.autoSizeColumn(1);
            sheet5.autoSizeColumn(2);
            sheet5.autoSizeColumn(3);
            sheet5.autoSizeColumn(4);
            sheet5.autoSizeColumn(5);
            sheet5.autoSizeColumn(6);

//------------------índices--------------------------------------------------------------------------------------
            Sheet sheet6 = workbook.createSheet("Índices");

            Row row6 = sheet6.createRow(0);

            Cell cell6 = row6.createCell(0);
            cell6.setCellValue("Lote");
            cell6.setCellStyle(headerCellStyle);

            cell6 = row6.createCell(1);
            cell6.setCellValue("Viabilidade %");
            cell6.setCellStyle(headerCellStyle);

            cell6 = row6.createCell(2);
            cell6.setCellValue("Fator Produção");
            cell6.setCellStyle(headerCellStyle);

            cell6 = row6.createCell(3);
            cell6.setCellValue("Mortalidade %");
            cell6.setCellStyle(headerCellStyle);

            cell6 = row6.createCell(4);
            cell6.setCellValue("C.A. dúzia de ovos");
            cell6.setCellStyle(headerCellStyle);

            cell6 = row6.createCell(5);
            cell6.setCellValue("C.A");
            cell6.setCellStyle(headerCellStyle);

            for (int i = 0; i < lotes.size(); i++) {

                Row dataRow = sheet6.createRow(i + 1);

                String s = "";

                try {
                    s = String.valueOf(lotes.get(i).getIndice().getFator_producao());
                    s = s.replace(".", "").substring(0, 3);
                } catch (Exception e) {
                    s = "0";
                }

                dataRow.createCell(0).setCellValue(lotes.get(i).getIdentificacao());
                dataRow.createCell(1).setCellValue(lotes.get(i).getIndice().getViabilidade());
                dataRow.createCell(2).setCellValue(s);
                dataRow.createCell(3).setCellValue(lotes.get(i).getIndice().getMortalidade());
                dataRow.createCell(4).setCellValue(lotes.get(i).getIndice().getCa_duzia());
                dataRow.createCell(5).setCellValue(lotes.get(i).getIndice().getIca());

            }

            sheet6.autoSizeColumn(0);
            sheet6.autoSizeColumn(1);
            sheet6.autoSizeColumn(2);
            sheet6.autoSizeColumn(3);
            sheet6.autoSizeColumn(4);
            sheet6.autoSizeColumn(5);

//---------------------------------------------------------------------------------------------------------------
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
            
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
