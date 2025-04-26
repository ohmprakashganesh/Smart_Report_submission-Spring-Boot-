package com.report.impl;

import org.springframework.stereotype.Service;

import com.report.entities.Feedback;
import com.report.repository.FeedbackRepo;
import com.report.services.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private  FeedbackRepo feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepo feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    // @Override
    // public Feedback createFeedback(Feedback feedback) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'createFeedback'");
    // }

    // @Override
    // public Feedback getFeedbackById(Long id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getFeedbackById'");
    // }

    // @Override
    // public Feedback updateFeedback(Long id, Feedback feedback) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'updateFeedback'");
    // }

    // @Override
    // public void deleteFeedback(Long id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'deleteFeedback'");
    // }

    @Override
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElseThrow(() -> new RuntimeException("Feedback not found"));
    }

    @Override
    public Feedback updateFeedback(Long id, Feedback feedback) {
        if (!feedbackRepository.existsById(id)) {
            throw new RuntimeException("Feedback not found");
        }
    
        return feedbackRepository.save(feedback);
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
