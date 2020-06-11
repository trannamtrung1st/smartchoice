/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.xmlparser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.xml.stream.Location;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.DTD;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import smartchoice.helper.FileHelper;
import smartchoice.helper.HttpHelper;
import smartchoice.helper.RegexHelper;
import smartchoice.helper.XMLHelper;

/**
 * Not thread safe
 *
 * @author TNT
 */
public class HTMLPreprocessorOld {
//
//    private static final String END_MATCHING_ERR_REGEX = "(.*)matching end-tag(.*)";
//    private static final String REF_ENTITY_END_ERR_REGEX = "(.*)reference to entity(.*)must end with the ';' delimiter(.*)";
//    private static final String ATTR_ERR_REGEX = "(.*)Attribute name(.*)must be followed by the ' = ' character(.*)";
//    private static final String ENTITY_REF_ERR_REGEX = "(.*)The entity(.*)was referenced, but not declared(.*)";
//    private static final String INVALID_CHAR_ERR_REGEX = "((.*)The value of attribute(.*)associated with an element type(.*)must not contain the(.*)character(.*))|"
//            + "((.*)The entity name must immediately follow the '&' in the entity reference(.*))";
//    private static final String ELEMENT_FOLLOW_ERR_REGEX = "(.*)Element type(.*)must be followed by either attribute specifications, \">\" or \"/>\"(.*)";
//    private static final String END_TAG_ERR_REGEX = "(.*)The end-tag for element type(.*)must end with a '>' delimiter(.*)";
//    private static final String START_END_ERR_REGEX = "(.*)ML document structures must start and end within the same entity(.*)";
//    private static final List<String> EMPTY_TAGS = Arrays.asList("area", "base", "br", "col", "embed", "hr", "img", "input", "keygen", "link", "meta", "param", "source", "track", "wbr");
//
//    private static final String HTML_DTD_LOCATION = "PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n"
//            + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"";
//    private static final String HTML_DTD_URL = "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd";
//    private static final String HTML_NS_DEC = "xmlns=\"http://www.w3.org/1999/xhtml\"";
//
//    private final LinkedList<XMLEvent> listEvents = new LinkedList<>();
//    private final LinkedList<Integer> listStartTagPos = new LinkedList<>();
//    private boolean setDTDRef;
//
//    public void setSetDTDRef(boolean setDTDRef) {
//        this.setDTDRef = setDTDRef;
//    }
//
//    public boolean getSetDTDRef() {
//        return setDTDRef;
//    }
//
//    public LinkedList<XMLEvent> getListEvents() {
//        return listEvents;
//    }
//
//    protected void addEvent(XMLEvent event) {
//        listEvents.add(event);
//    }
//
//    protected void addStartElement(XMLEvent event) {
//        listEvents.add(event);
//        listStartTagPos.add(listEvents.size() - 1);
//    }
//
//    protected int addEndElement(XMLEvent event) {
//        listEvents.add(event);
//        return listStartTagPos.removeLast();
//    }
//
//    protected void removeNotWellFormedContent(String dataPath, String tmpPath,
//            int startTagPos, Location wrongEndLoc) throws FileNotFoundException, IOException {
//        XMLEvent startEvent = listEvents.get(startTagPos);
//        String startTagName = startEvent.asStartElement().getName().toString();
//        int endRow = wrongEndLoc.getLineNumber();
//        int endCol = wrongEndLoc.getColumnNumber();
//        List<String> lines = new ArrayList<>();
//        try (FileReader fr = new FileReader(dataPath);
//                BufferedReader br = new BufferedReader(fr);) {
//            int curRow = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                curRow++;
//                if (curRow == endRow) {
//                    int startOfEndTag = endCol - 3;
//                    int endOfEndTag = line.substring(startOfEndTag).indexOf('>') + startOfEndTag;
//                    line = line.substring(0, startOfEndTag) + "</" + startTagName + ">" + line.substring(endOfEndTag + 1);
//                }
//                lines.add(line);
//            }
//        }
//        writeToFile(lines, tmpPath);
//    }
//
//    protected void processEndTagErr(String dataPath, String tmpPath,
//            int startTagPos, Location errLoc) throws FileNotFoundException, IOException {
//        XMLEvent startEvent = listEvents.get(startTagPos);
//        String startTagName = startEvent.asStartElement().getName().toString();
//        int errRow = errLoc.getLineNumber();
//        int errCol = errLoc.getColumnNumber();
//        List<String> lines = new ArrayList<>();
//        try (FileReader fr = new FileReader(dataPath);
//                BufferedReader br = new BufferedReader(fr);) {
//            int curRow = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                curRow++;
//                if (curRow == errRow) {
//                    int startOfEndTag = errCol - startTagName.length() - 2;
//                    line = line.substring(0, startOfEndTag - 1) + "</" + startTagName + ">" + line.substring(startOfEndTag - 1);
//                }
//                lines.add(line);
//            }
//        }
//        writeToFile(lines, tmpPath);
//    }
//
//    protected void addEndTagForEmptyTag(String dataPath, String tmpPath,
//            Location eLoc) throws FileNotFoundException, IOException {
//        int eRow = eLoc.getLineNumber();
//        int eCol = eLoc.getColumnNumber();
//        List<String> lines = new ArrayList<>();
//        try (FileReader fr = new FileReader(dataPath);
//                BufferedReader br = new BufferedReader(fr);) {
//            int curRow = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                curRow++;
//                if (curRow == eRow) {
//                    line = line.substring(0, eCol - 2) + "/" + line.substring(eCol - 2);
//                }
//                lines.add(line);
//            }
//        }
//        writeToFile(lines, tmpPath);
//    }
//
//    protected void processDocumentStartEndErr(String dataPath, String tmpPath,
//            int startTagPos, Location errLoc) throws FileNotFoundException, IOException {
//        XMLEvent startEvent = listEvents.get(startTagPos);
//        String startTagName = startEvent.asStartElement().getName().toString();
//        if (EMPTY_TAGS.contains(startTagName)) {
//            Location startLoc = startEvent.getLocation();
//            addEndTagForEmptyTag(dataPath, tmpPath, startLoc);
//            return;
//        }
//        List<String> lines = new ArrayList<>();
//        try (FileReader fr = new FileReader(dataPath);
//                BufferedReader br = new BufferedReader(fr);) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                lines.add(line);
//            }
//            lines.add("</" + startTagName + ">");
//        }
//        writeToFile(lines, tmpPath);
//    }
//
//    public void parseURL(String url) throws IOException, XMLStreamException {
//        String tempPath = null;
//        try (InputStream is = HttpHelper.getInputStream(url)) {
//            tempPath = FileHelper.saveStreamToTempFile(is);
//            int skip = 0;
//            while (skip != -1) {
//                skip = parseFile(tempPath, tempPath, skip);
//            }
//        } finally {
//            if (tempPath != null) {
////                FileHelper.delete(tempPath);
//            }
//        }
//    }
//
//    public void parseFile(String dataPath, String tmpPath) throws IOException, XMLStreamException {
//        try {
//
//            int skip = 0;
//            while (skip != -1) {
//                if (skip == 0) {
//                    skip = parseFile(dataPath, tmpPath, skip);
//                } else {
//                    skip = parseFile(tmpPath, tmpPath, skip);
//                }
//            }
//        } finally {
////            FileHelper.delete(tmpPath);
//        }
//    }
//
//    protected void writeToFile(List<String> lines, String path) throws IOException {
//        try (FileWriter fw = new FileWriter(path);
//                BufferedWriter bw = new BufferedWriter(fw);) {
//            for (String l : lines) {
//                if (!l.trim().isEmpty()) {
//                    bw.write(l + "\n");
//                }
//            }
//        }
//    }
//
//    protected void replaceRefEntity(String dataPath, String tmpPath,
//            Location errLoc) throws FileNotFoundException, IOException {
//        int errRow = errLoc.getLineNumber();
//        int errCol = errLoc.getColumnNumber();
//        List<String> lines = new ArrayList<>();
//        try (FileReader fr = new FileReader(dataPath);
//                BufferedReader br = new BufferedReader(fr);) {
//            int curRow = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                curRow++;
//                if (curRow == errRow) {
//                    int refLoc = line.substring(0, errCol).lastIndexOf('&');
//                    line = line.substring(0, refLoc) + "&#38;" + line.substring(refLoc + 1);
//                }
//                lines.add(line);
//            }
//        }
//        writeToFile(lines, tmpPath);
//    }
//
//    protected void addValueForKeyOnlyAttr(String dataPath, String tmpPath,
//            Location errLoc) throws FileNotFoundException, IOException {
//        int errRow = errLoc.getLineNumber();
//        int errCol = errLoc.getColumnNumber();
//        List<String> lines = new ArrayList<>();
//        try (FileReader fr = new FileReader(dataPath);
//                BufferedReader br = new BufferedReader(fr);) {
//            int curRow = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                curRow++;
//                if (curRow == errRow) {
//                    line = line.substring(0, errCol - 1) + "=\"\" " + line.substring(errCol - 1);
//                }
//                lines.add(line);
//            }
//        }
//        writeToFile(lines, tmpPath);
//    }
//
//    protected void removeEntity(String dataPath, String tmpPath,
//            Location entityLoc) throws FileNotFoundException, IOException {
//        int entityRow = entityLoc.getLineNumber();
//        int entityCol = entityLoc.getColumnNumber();
//        List<String> lines = new ArrayList<>();
//        try (FileReader fr = new FileReader(dataPath);
//                BufferedReader br = new BufferedReader(fr);) {
//            int curRow = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                curRow++;
//                if (curRow == entityRow) {
//                    int startEntityPos = line.substring(0, entityCol - 1).lastIndexOf("&");
//                    line = line.substring(0, startEntityPos) + line.substring(entityCol - 1);
//                }
//                lines.add(line);
//            }
//        }
//        writeToFile(lines, tmpPath);
//    }
//
//    protected void processElementFollowErr(String dataPath, String tmpPath,
//            Location errLoc) throws FileNotFoundException, IOException {
//        int errRow = errLoc.getLineNumber();
//        int errCol = errLoc.getColumnNumber();
//        List<String> lines = new ArrayList<>();
//        try (FileReader fr = new FileReader(dataPath);
//                BufferedReader br = new BufferedReader(fr);) {
//            int curRow = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                curRow++;
//                if (curRow == errRow) {
//                    line = line.substring(0, errCol - 1) + " " + line.substring(errCol - 1);
//                }
//                lines.add(line);
//            }
//        }
//        writeToFile(lines, tmpPath);
//    }
//
//    protected void replaceInvalidCharInAttr(String dataPath, String tmpPath,
//            Location charLoc) throws FileNotFoundException, IOException {
//        int charRow = charLoc.getLineNumber();
//        int charCol = charLoc.getColumnNumber();
//        List<String> lines = new ArrayList<>();
//        try (FileReader fr = new FileReader(dataPath);
//                BufferedReader br = new BufferedReader(fr);) {
//            int curRow = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                curRow++;
//                if (curRow == charRow) {
//                    String invalidChar = line.substring(charCol - 1, charCol);
//                    String replaceChar = "";
//                    switch (invalidChar) {
//                        case "<":
//                            replaceChar = "&lt;";
//                            break;
//                        case ">":
//                            replaceChar = "&gt;";
//                            break;
//                    }
//                    line = line.substring(0, charCol - 1) + replaceChar + line.substring(charCol);
//                }
//                lines.add(line);
//            }
//        }
//        writeToFile(lines, tmpPath);
//    }
//
//    protected void addDocTypeLocation(String dataPath, String tmpPath, Location dtdLoc) throws FileNotFoundException, IOException {
//        int dtdRow = dtdLoc.getLineNumber();
//        int dtdCol = dtdLoc.getColumnNumber();
//        List<String> lines = new ArrayList<>();
//        try (FileReader fr = new FileReader(dataPath);
//                BufferedReader br = new BufferedReader(fr);) {
//            int curRow = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                curRow++;
//                if (curRow == dtdRow) {
//                    line = line.substring(0, dtdCol - 2) + " " + HTML_DTD_LOCATION + line.substring(dtdCol - 2);
//                }
//                lines.add(line);
//            }
//        }
//        writeToFile(lines, tmpPath);
//    }
//
//    protected void addHtmlNS(String dataPath, String tmpPath, Location htmlLoc) throws FileNotFoundException, IOException {
//        int htmlRow = htmlLoc.getLineNumber();
//        int htmlCol = htmlLoc.getColumnNumber();
//        List<String> lines = new ArrayList<>();
//        try (FileReader fr = new FileReader(dataPath);
//                BufferedReader br = new BufferedReader(fr);) {
//            int curRow = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                curRow++;
//                if (curRow == htmlRow) {
//                    line = line.substring(0, htmlCol - 2) + " " + HTML_NS_DEC + line.substring(htmlCol - 2);
//                }
//                lines.add(line);
//            }
//        }
//        writeToFile(lines, tmpPath);
//    }
//    
//    
//    protected void autoCloseEmptyTag(String dataPath, String tmpPath, Location tagLoc) throws FileNotFoundException, IOException {
//        int tagRow = tagLoc.getLineNumber();
//        int tagCol = tagLoc.getColumnNumber();
//        List<String> lines = new ArrayList<>();
//        try (FileReader fr = new FileReader(dataPath);
//                BufferedReader br = new BufferedReader(fr);) {
//            int curRow = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                curRow++;
//                if (curRow == tagRow) {
//                    line = line.substring(0, tagCol - 2) + " " + HTML_NS_DEC + line.substring(tagCol - 2);
//                }
//                lines.add(line);
//            }
//        }
//        writeToFile(lines, tmpPath);
//    }
//
//    protected int parseFile(String dataPath, String tmpPath, int skip) throws IOException, XMLStreamException {
//        try (InputStream is = new FileInputStream(dataPath)) {
//            XMLEventReader reader = XMLHelper.getXMLEventReader(is);
//            int turn = 0;
//            StartElement lastEmptySE = null;
//            while (reader.hasNext()) {
//                if (++turn <= skip) {
//                    continue;
//                }
//                try {
//                    XMLEvent event = reader.nextEvent();
////                    System.out.println(event);
//                    int type = event.getEventType();
//                    switch (type) {
//                        case XMLEvent.CHARACTERS:
//                        case XMLEvent.SPACE:
//                            Characters chars = event.asCharacters();
//                            if (!chars.isWhiteSpace()) {
//                                addEvent(event);
//                            }
//                            break;
//                        case XMLEvent.END_ELEMENT:
//                            addEndElement(event);
//                            break;
//                        case XMLEvent.START_ELEMENT:
//                            StartElement se = event.asStartElement();
//                            String tagName = se.getName().toString();
//                            if (lastEmptySE != null) {
//                                
//                                return listEvents.size();
//                            } else if (EMPTY_TAGS.contains(tagName)) {
//                                lastEmptySE = se;
//                            }
//                            if (setDTDRef) {
//                                String namespaceUri = se.getNamespaceURI("");
//                                if (tagName.equals("html") && namespaceUri.isEmpty()) {
//                                    Location loc = se.getLocation();
//                                    addHtmlNS(dataPath, tmpPath, loc);
//                                    return listEvents.size();
//                                }
//                            }
//                            addStartElement(event);
//                            lastEmptySE = se;
//                            break;
//                        case XMLEvent.DTD:
//                            DTD dtd = (DTD) event;
//                            String docType = dtd.getDocumentTypeDeclaration();
//                            if (setDTDRef && docType.startsWith("<!DOCTYPE html") && !docType.contains(HTML_DTD_URL)) {
//                                addDocTypeLocation(dataPath, tmpPath, dtd.getLocation());
//                                return listEvents.size();
//                            }
//                            addEvent(event);
//                        case XMLEvent.END_DOCUMENT:
//                            break;
//                        default:
//                            addEvent(event);
//                    }
//                } catch (XMLStreamException e) {
////                    e.printStackTrace();
//                    is.close();
//                    String mess = e.getMessage();
//                    if (isMatchingEndTagError(mess)) {
//                        Location loc = e.getLocation();
//                        Integer startTagPos = listStartTagPos.removeLast();
//                        removeNotWellFormedContent(dataPath, tmpPath, startTagPos, loc);
//                    } else if (isRefEntityEndError(mess)) {
//                        Location loc = e.getLocation();
//                        replaceRefEntity(dataPath, tmpPath, loc);
//                    } else if (isAttrErr(mess)) {
//                        Location loc = e.getLocation();
//                        addValueForKeyOnlyAttr(dataPath, tmpPath, loc);
//                    } else if (isEntityRefErr(mess)) {
//                        removeEntity(dataPath, tmpPath, e.getLocation());
//                    } else if (isInvalidCharErr(mess)) {
//                        replaceInvalidCharInAttr(dataPath, tmpPath, e.getLocation());
//                    } else if (isElementFollowErr(mess)) {
//                        processElementFollowErr(dataPath, tmpPath, e.getLocation());
//                    } else if (isEndTagError(mess)) {
//                        Integer startTagPos = listStartTagPos.removeLast();
//                        processEndTagErr(dataPath, tmpPath, startTagPos, e.getLocation());
//                    } else if (isStartEndError(mess)) {
//                        Integer startTagPos = listStartTagPos.removeLast();
//                        processDocumentStartEndErr(dataPath, tmpPath, startTagPos, e.getLocation());
//                    } else {
//                        System.out.println("Unhandled exception");
//                    }
//                    return listEvents.size();
//                }
//            }
//        }
//        return -1;
//    }
//
//    protected boolean isMatchingEndTagError(String mess) {
//        return RegexHelper.matchDotAll(mess, END_MATCHING_ERR_REGEX);
//    }
//
//    protected boolean isRefEntityEndError(String mess) {
//        return RegexHelper.matchDotAll(mess, REF_ENTITY_END_ERR_REGEX);
//    }
//
//    protected boolean isAttrErr(String mess) {
//        return RegexHelper.matchDotAll(mess, ATTR_ERR_REGEX);
//    }
//
//    protected boolean isEntityRefErr(String mess) {
//        return RegexHelper.matchDotAll(mess, ENTITY_REF_ERR_REGEX);
//    }
//
//    protected boolean isInvalidCharErr(String mess) {
//        return RegexHelper.matchDotAll(mess, INVALID_CHAR_ERR_REGEX);
//    }
//
//    protected boolean isElementFollowErr(String mess) {
//        return RegexHelper.matchDotAll(mess, ELEMENT_FOLLOW_ERR_REGEX);
//    }
//
//    protected boolean isEndTagError(String mess) {
//        return RegexHelper.matchDotAll(mess, END_TAG_ERR_REGEX);
//    }
//
//    protected boolean isStartEndError(String mess) {
//        return RegexHelper.matchDotAll(mess, START_END_ERR_REGEX);
//    }
}
