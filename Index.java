/*
 *   This file is part of the computer assignment for the
 *   Information Retrieval course at KTH.
 *
 *   First version:  Johan Boye, 2010
 *   Second version: Johan Boye, 2012
 *   Additions: Hedvig Kjellström, 2012-14
 */

package ir;

import java.util.HashMap;
import java.util.Iterator;

public interface Index {

    /* Index types */
    public static final int HASHED_INDEX = 0;

    /* Query types */
    public static final int INTERSECTION_QUERY = 0;
    public static final int PHRASE_QUERY = 1;
    public static final int RANKED_QUERY = 2;

    /* Ranking types */
    public static final int TF_IDF = 0;
    public static final int PAGERANK = 1;
    public static final int COMBINATION = 2;

    /* Structure types */
    public static final int UNIGRAM = 0;
    public static final int BIGRAM = 1;
    public static final int SUBPHRASE = 2;

    public HashMap<String,Integer> docLengths = new HashMap<String,Integer>();

    public void insert( String token, int docID, int offset );
    public Iterator<String> getDictionary();
    public PostingsList getPostings( String token );
    public PostingsList search( Query query, int queryType, int rankingType, int structureType );
    public void cleanup();
    public int size();
    public void transferIndexToDisk(int blockID);
    public String getFilePath(String id);
    public void addFilePath(String key, String value);
    public void setFilePaths(HashMap<String, String> map);
    public void setNumDocs(int n);
    public void calculateScores();
    public void setArticleTitles(HashMap<String, Integer> map);
    public void setPageRanks(HashMap<Integer, Double> map);
    public void insertBigram(String token, int docID, int offset);
    public void calculateBigramScores();
    public int getNumDocs();
    public void setNumBigramDocs(int bigramCount);

}
