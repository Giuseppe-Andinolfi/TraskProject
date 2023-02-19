@Entity
public class TechnologyCandidate {
    @EmbeddedId
    private TechnologyCandidateId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("candidateId")
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("technologyId")
    private Technology technology;

    private int level;
    private String note;

    // constructors, getter and setter methods, equals, hashcode and tostring
}