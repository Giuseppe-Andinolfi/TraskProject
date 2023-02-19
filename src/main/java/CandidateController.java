@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    private final CandidateRepository candidateRepository;
    private final TechnologyRepository technologyRepository;

    public CandidateController(CandidateRepository candidateRepository, TechnologyRepository technologyRepository) {
        this.candidateRepository = candidateRepository;
        this.technologyRepository = technologyRepository;
    }

    @GetMapping
    public List<Candidate> getAllCandidate() {
        return candidateRepository.findAll();
    }

    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate not found with id " + id));
    }

    @PostMapping
    public Candidate createCandidate(@Valid @RequestBody Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @PutMapping("/{id}")
    public Candidate updateCandidate(@PathVariable Long id, @Valid @RequestBody Candidate candidateRequest) {
        return candidateRepository.findById(id)
                .map(candidate -> {
                    candidate.setName(candidateRequest.getName());
                    candidate.setSurname(candidateRequest.getSurname());
                    candidate.setEmail(candidateRequest.getEmail());
                    candidate.setPhone(candidateRequest.getPhone());
                    return candidateRepository.save(candidate);
                }).orElseThrow(() -> new ResourceNotFoundException("Candidate not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCandidate(@PathVariable Long id) {
        return candidateRepository.findById(id)
                .map(candidate -> {
                    candidateRepository.delete(candidate);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Candidate not found with id " + id));
    }
}