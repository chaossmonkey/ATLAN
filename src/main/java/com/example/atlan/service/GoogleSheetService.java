package com.example.atlan.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.ValueRange;
import java.util.List;

@Service
public class GoogleSheetsService {

    private final String APPLICATION_NAME = "Your Application Name";
    private final String SPREADSHEET_ID = "Your Spreadsheet ID";
    private final String RANGE = "Sheet1"; // Change to your sheet name and range
    private final NetHttpTransport httpTransport;
    private final JsonFactory jsonFactory;

    @Autowired
    public GoogleSheetsService(NetHttpTransport httpTransport, JsonFactory jsonFactory) {
        this.httpTransport = httpTransport;
        this.jsonFactory = jsonFactory;
    }

    public void writeToGoogleSheets(List<List<Object>> data) throws IOException {
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(getClass().getResourceAsStream("/client_secrets.json")));

        GoogleCredential credential = new GoogleCredential.Builder()
                .setTransport(httpTransport)
                .setJsonFactory(jsonFactory)
                .setClientSecrets(clientSecrets)
                .build();

        Sheets sheetsService = new Sheets.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange body = new ValueRange().setValues(data);
        UpdateValuesResponse result = sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, RANGE, body)
                .setValueInputOption("RAW")
                .execute();

        System.out.println("Updated " + result.getUpdatedCells() + " cells.");
    }
}
